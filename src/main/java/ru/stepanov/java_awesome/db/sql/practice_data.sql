INSERT INTO public.products ("name",product_id,price,"cost") VALUES
('Bridge','1111',210,60),
('Hoody','2222',340,100),
('T-Short A','1234',150,30),
('T-Short B','5678',190,50);

INSERT INTO public.sales (product_id,"date",units,"size") VALUES
('1234','2021-01-01 08:19:12',10,'L'),
('1234','2020-12-31 08:19:12',100,'L'),
('5678','2020-12-31 08:19:12',250,'L'),
('1111','2020-12-31 08:19:12',151,'L'),
('2222','2020-12-31 08:19:12',40,'L'),
('2222','2021-01-01 08:19:12',400,'L'),
('2222','2021-01-01 08:19:12',120,'M'),
('5678','2021-01-01 08:19:12',120,'M');


WITH grouped_operation_data AS (
    SELECT to_char(timezone('Europe/Moscow', timezone('utc'::text, tpp_operation.operation_date)), 'YYYY-MM'::text) AS report_month,
           tpp_operation.terminal_acquirer_id AS acquirer_id,
           v_tpp_operation_state.operation_state_id,
           dict_region_oktmo.description AS region_name,
           sum(tpp_operation.final_amount) AS total_amount,
           count(1) AS total_count
    FROM tpp_operation
             join v_tpp_operation_state ON v_tpp_operation_state.operation_id = tpp_operation.operation_id
             LEFT JOIN dict_region_oktmo ON tpp_operation.merchant_region::text = dict_region_oktmo.code::text
    WHERE v_tpp_operation_state.operation_state_id = ANY (ARRAY[1, 3])
    GROUP BY (to_char(timezone('Europe/Moscow'::text, timezone('utc'::text, tpp_operation.operation_date)), 'YYYY-MM'::text)),
             tpp_operation.terminal_acquirer_id,
             v_tpp_operation_state.operation_state_id,
             tpp_operation.merchant_region,
             dict_region_oktmo.description
)
SELECT grouped_operation_data.report_month,
       grouped_operation_data.acquirer_id,
       grouped_operation_data.region_name,
       sum(grouped_operation_data.total_count) AS total_count,
       sum(grouped_operation_data.total_count) FILTER (WHERE grouped_operation_data.operation_state_id = 1) AS total_count_succesfull,
       sum(grouped_operation_data.total_count) FILTER (WHERE grouped_operation_data.operation_state_id = 3) AS total_count_unsuccesfull,
       sum(grouped_operation_data.total_amount) AS total_amount,
       sum(grouped_operation_data.total_amount) FILTER (WHERE grouped_operation_data.operation_state_id = 1) AS total_amount_successfull,
       sum(grouped_operation_data.total_amount) FILTER (WHERE grouped_operation_data.operation_state_id = 3) AS total_amount_unsuccessfull
FROM grouped_operation_data
GROUP BY grouped_operation_data.report_month,
         grouped_operation_data.acquirer_id,
         grouped_operation_data.region_name