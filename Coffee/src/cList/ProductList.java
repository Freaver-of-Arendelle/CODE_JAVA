package cList;

/**
 * @author Freaver
 */
public class ProductList
{
    private final CoffeeAccessoryList coffeeAccessoryList = new CoffeeAccessoryList();

    private final CoffeeBrewerList coffeeBrewerList = new CoffeeBrewerList();

    private final CoffeeList coffeeList = new CoffeeList();

    public void showCurrentOrder()
    {
        coffeeList.printCurrentOrder();
        coffeeBrewerList.printCurrentOrder();
        coffeeAccessoryList.printCurrentOrder();
    }

    @Override
    public String toString()
    {
        return "ProductList{" +
               "coffeeAccessoryList=" + coffeeAccessoryList +
               ", coffeeBrewerList=" + coffeeBrewerList +
               ", coffeeList=" + coffeeList +
               '}';
    }

    public void clear()
    {
        coffeeAccessoryList.clear();
        coffeeBrewerList.clear();
        coffeeList.clear();
    }

    public CoffeeAccessoryList getCoffeeAccessoryList()
    {
        return coffeeAccessoryList;
    }

    public CoffeeBrewerList getCoffeeBrewerList()
    {
        return coffeeBrewerList;
    }

    public CoffeeList getCoffeeList()
    {
        return coffeeList;
    }

    public void setCoffeeAccessoryList(String code)
    {
        this.coffeeAccessoryList.numberAdd(code);
    }

    public void setCoffeeBrewerList(String code)
    {
        this.coffeeBrewerList.numberAdd(code);
    }

    public void setCoffeeList(String code)
    {
        this.coffeeList.numberAdd(code);
    }

    public void deleteCoffeeList(String code)
    {
        this.coffeeList.numberDelete(code);
    }

    public void deleteCoffeeBrewerList(String code)
    {
        this.coffeeBrewerList.numberDelete(code);
    }

    public void deleteCoffeeAccessoryList(String code)
    {
        this.coffeeAccessoryList.numberDelete(code);
    }
}
