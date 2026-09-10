package com;

import com.driver.SingletonDriver;
import com.page.MainPage;
import com.page.ProductsPage;
import com.structure.Categories;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTests {
    private Categories category;

    protected ProductsPage openProductsPage() {
        new MainPage();
        return new MainPage()
                .openNavigation()
                .openCategory(category);
    }

    @Parameters({"browser", "category"})
    @BeforeTest
    public void createDriver(@Optional("firefox") String browser,
                             @Optional("XiaomiGlassesVirtualReality") Categories category) {
        SingletonDriver.getInstance(browser);
        this.category = category;
    }

    @AfterTest
    public void closeDriver() {
        SingletonDriver.closeDriver();
    }
}
