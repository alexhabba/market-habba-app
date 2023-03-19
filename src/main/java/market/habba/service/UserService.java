package market.habba.service;

import market.habba.entity.User;
import market.habba.model.UserRequestDto;

/**
 * Сервис для работы с информацией о пользователе.
 */
public interface UserService {
    /**
     * Получение информации о пользователе.
     *
     * @param email E-mail пользователя
     * @return Пользователь
     */
    User getUserByEmail(String email);

    /**
     * Добавление нового пользователя.
     *
     * @param userRequestDto Дто пользователя
     */
    User addNewUser(UserRequestDto userRequestDto);
}
