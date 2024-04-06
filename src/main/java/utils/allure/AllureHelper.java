package utils.allure;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;

public class AllureHelper {
    private static final AllureLifecycle allure = Allure.getLifecycle();

    @Step("Оформить сформированный файл как вложение к отчету allure")
    public static void attachFileCsv(String name, byte[] bytes) {
        allure.addAttachment(name, "csv", "csv", bytes);
    }
}
