# Проект букмекерского приложения.
В приложении у пользователя одна из двух ролей: администратор и клиент. Так же будет разделён функционал для клиента и администратора.
- при попытке регистрации нового пользователя с ником уже существуещего или при не совпадении полей с паролями, выведится сообщение об ошибке и будет предложено заново ввести данные.
- после регистрации пользователю присваивается роль userEntity, пользователь авторизируется, создается куки и перенаправляется на страницу пользователя.
- при попытке пройти по ссылке hello не авторизированному пользователю и без куки, фильтр перенаправит на стрраницу логина.
- При неправильном вводе логина или пароля выводиться сообщение об ошибке. После авторизации пользователь будет перенаправлен на страницу администратора или usera в зависимости от роли.
- После авторизации ссылка userlogin меняется на logout, ссылка на регистрацию убирается
- При переходе по ссылке logout удаляются данные из сессии(userlogin, role) и удаляется куки, идет редирект на index.jsp.
- На странице usera можно обновить информацию в полях cashAccountDTO и password. Автозаполнение происходит текущеми данными.

Для теста регистрации и авторизации в базе 2 пользователя: логин b пароль b; логин с пароль c.
администратор - логин a пароль a.

TO DO

Функционал администратора:
1) Может создавать событие в одной из категорий(премьер лига англии или лига чемпионов, возможно еще другие), выставляя 3 коэфициента:
на выйгрыш, ничью и поражение.
2) Принимать запросы клиентов о верификации. Изменять статус клиентов: прошел верефикацию, не прошел верефикацию, заблокирован.
3) Просматривать данные клиентов и выводить их список(Возможно сортировать по кличеству сделок, общему выигрышу-убытку)

Функционал Клиента:

1) После регистрации клиент может видеть события добавленные администратором.
2) После верификации(отправка "скана паспорта") есть возможность сделать депозит, ставки, вывод средств.
3) Просматривать историю сделок и обновлять личную информацию.
