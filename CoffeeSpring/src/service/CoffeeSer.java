package ser;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  00:13
 */
public interface CoffeeSer {
    void showCurrentList();
    void addProduct(String code);
    void removeProduct(String code);
    void clear();
    void getProduct();
    void showList();

}
