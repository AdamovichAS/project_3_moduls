# Проект букмекерской конторы.
В приложении у пользователя одна из двух ролей: администратор и клиент. Так же будет разделён функционал для клиента и администратора.
Для теста регистрации и авторизации в базе 2 пользователя логин b пароль b; логин с пароль c.
администратор - логин a пароль a.

TO DO

Функционал администратора:
1) Может создавать событие в одной из категорий(премьер лига англии или лига чемпионов, возможно еще другие), выставляя 3 коэфициента:
на выйгрыш, ничью и поражение.
2) Принимать запросы клиентов о верификации. Изменять статус клиентов: прошел верефикацию, не прошел верефикацию, заблокирован.
3) Просматривать данные клиентов и выводить их список(Возможно сортировать по кличеству сделок, общему выигрышу-убытку)

Функционал Клиента:

1) После регистрации клиент может видеть события добавленные администратором.
2) После верификации(отправка "скана паспорта") есть возможность сделать депозит и ставки.
3) Просматривать ситорию сделок и обновлять личную информацию
