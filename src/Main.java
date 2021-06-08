import java.util.Scanner;

public class Main {
    public static User[] getUser() {
        User user1 = new User("oriyon", "Pp970712", "pers@mail.ru", 25);
        User user2 = new User("isma", "ism135", "isma@mail.ru", 20);
        User user3 = new User("Aza", "Az0272", "aza02@mail.ru", 16);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUser();
        for (User user : users) {
            if (login.equalsIgnoreCase(user.getLogin()) && password.equalsIgnoreCase(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Вы младше 18 лет!");
        }
    }

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите свой логин!");
        String login = scanner.nextLine();
        System.out.println("Введите свой пароль!");
        String password = scanner.nextLine();

        validateUser(getUserByLoginAndPassword(login, password));

        System.out.println("Доступ предоставлен!");
    }
}