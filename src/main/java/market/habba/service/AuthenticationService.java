package market.habba.service;

import java.util.UUID;

/**
 * Сервис для работы с аутентификацией.
 */
public interface AuthenticationService {

    /**
     * Получение идентификатора пользователя.
     *
     * @return Идентификатор пользователя
     */
    UUID getUserId();
}
