package test;

import page.*;
import org.testng.annotations.Test;

public class AsosTest extends CommonConditions {
    @Test(description = "Найти мужские повседневные кроссовки фирмы Adidas")
    public void AsosTest1() throws InterruptedException {
        new HomePage(driver)
                .openPage()
                .setSearchQuery("Кроссовки Adidas")
                .selectBrand("brand_17")
                .selectGender("floor_1001")
                .getResults();
    }

    @Test(description = "Узнать цену самого дешевого поло Ralph Lauren в Индии")
    public void AsosTest2() throws InterruptedException {
        new HomePage(driver)
                .openPage()
                .selectCountry("India")
                .setSearchQuery("polo ralph lauren polo shirt")
                .sort("plp_web_sort_price_low_to_high")
                .getResults();

    }

    @Test(description = "Поиск мужских бело-черных кроссовок \"adidas Originals Superstar Bonega\", размер \"Uk 3\"")
    public void AsosTest3() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .chooseMaleGender()
                .setSearchQuery("adidas Originals Superstar Bonega")
                .selectColour("base_colour_5")
                .selectSize("size_115")
                .getResults();
    }

    @Test(description = "Поиск всех женских джинсов. Модель: \"Mom jeans\", цвет: \"Black\", размер \"UK 4\", бренда: \"Bershka\"")
    public void AsosTest4() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .chooseFemaleGender()
                .setSearchQuery("Mom jeans")
                .selectBrand("brand_15370")
                .selectColour("base_colour_4")
                .selectSize("size_115");
    }

    @Test(description = "Поиск мужских кроссовок: \"Nike Air Force 1\". Цвет: \"Brown\", размер: \"UK 6\", цена: \"£134.95\"")
    public void AsosTest5() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .chooseMaleGender()
                .setSearchQuery("Nike Air Force 1")
                .selectColour("base_colour_10")
                .selectSize("size_116")
                .selectPriceRange(110, 135)
                .getResults()
                .openFoundItem("product-202883016");
    }

    @Test(description = "Поиск кед. Модель: \"Converse Chuck 70 Hi unisex trainers\". Цвет: \"Black\"")
    public void AsosTest6() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .setSearchQuery("Converse Chuck 70 Hi unisex trainer")
                .selectColour("base_colour_4")
                .getResults();
    }

    @Test(description = "Поиск всех Hoodie бренда: \"Reebok\", размер \"Uk 8\", цвет: \"Black\"")
    public void AsosTest7() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .setSearchQuery("Hoodie Reebok")
                .selectColour("base_colour_4")
                .selectSize("size_117")
                .getResults();
    }

    @Test(description = "Поиск всех Shorts, бренд\"Bershka\", размер \"W28\", цвет: \"Blue\"")
    public void AsosTest8() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .setSearchQuery("Shorts")
                .selectColour("base_colour_3")
                .selectSize("size_1770")
                .selectBrand("brand_15370")
                .getResults();
    }

    @Test(description = "Поиск всех женских \"Shoes\" бренд: \"ASOS DESIGN\", размер \"U2\", цвет: \"Brown\"")
    public void AsosTest9() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .chooseFemaleGender()
                .setSearchQuery("Shoes")
                .selectColour("base_colour_10")
                .selectSize("size_130")
                .selectBrand("brand_53")
                .getResults();
    }

    @Test(description = "Поиск всех мужских \"Shoes\". Бренд: \"ASOS DESIGN\", размер \"U2\", цвет: \"Green\"")
    public void AsosTest10() throws InterruptedException {
        new GooglePage(driver)
                .openPage()
                .setSearchQuery("ASOS")
                .goToAsos()
                .chooseMaleGender()
                .setSearchQuery("Shoes")
                .selectColour("base_colour_2")
                .selectSize("size_130")
                .selectBrand("brand_53")
                .getResults();
    }
}
