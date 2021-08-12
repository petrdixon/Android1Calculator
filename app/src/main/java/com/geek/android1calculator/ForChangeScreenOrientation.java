package com.geek.android1calculator;

import java.io.Serializable;

public class ForChangeScreenOrientation implements Serializable {

    private CharSequence formulaText;

    public void setFormulaText(CharSequence formulaText) {
        this.formulaText = formulaText;
    }

    public CharSequence getFormulaText() {
        return formulaText;
    }
}


//    Создайте активити с настройками, где включите выбор темы приложения.
//        Доделайте приложение «Калькулятор». Это последний урок с созданием приложения «Калькулятор».
//        * Сделайте интент-фильтр для запуска калькулятора извне, а также напишите тестовое приложение, запускающее приложение-калькулятор.
//        * Задача для дополнительного обучения.


// по нажатию кнопки из мейн, через интент, в сеттингс передаю ThemeStatus
// в сетингс получаю из интент
// запускаю в метод getTheme
// полученное присваиваю style
// style сохраняю в parcelable
// recreate ?
// в мейн:
// забираю style из parcelable
// устанавливаю как тему

// создали Account implements Parcelable
//с конструкторами
//в мейн создали объект account класса Account
// и передали в интент и в Активити runSettings.putExtra(YOUR_ACCOUNT, account);
//Таким образом мы отправили сложный объект во вторую активити. Теперь надо сделать получение этих данных.
