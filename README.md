# PPvisL3
ППвИС Лабораторная работа 3 Завацкий Константин 921702 Вриант 1 Модель банкомата
Лабораторную работу я решил выполнить в виде android приложения для наглядности, и просто мне это показалось интерестным.
При разработке использовал паттерн MVVM. Для данного проекта паттерн оказался не нужным т.к. его целесообразно использовать когда 
в приложении сложные экраны которые нужно часто обновлять, но мне просто было интересно его опробывать так что воот.
Паттерн предусматривает разделение кода на 3 модуля(Model, View, ViewModel)

В Models, описаны следуюцие классы:
1) CardNumber описывает код на карте.
2) Rate описывает курсы валют, данные представлены константами.
3) Money описывает деньги в определенной валюте, содержит методы по преобразовании из одной валюты в другую(согласно курсу валют).
4) DebitCard описывает дебитовую карту котороя содержит номер карты и деньги в опр. валюте. 

В пакете View лежат различные активности для каждого экрана.

ViewModels лежат в основном пакете. Не для каждого экрана рисовал отдельный экран где возможно переиспользовал.

Не все viewModel написаны с нуля (PutMoneyViewModel, TransferSelectCountViewModel, TransferViewModel унаследованы) это было сделано для предотвращения дублирования кода.
