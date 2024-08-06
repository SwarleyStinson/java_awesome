@Service
public class UserService {

    @Autowired
    private TransactionTemplate template;

    public Long registerUser(User user) {
        Long id = template.execute(status ->  {
            // выполнить некоторый SQL, который, например,
            // вставляет пользователя в базу данных
            // и возвращает автогенерированный идентификатор
            return id;
        });
    }
}