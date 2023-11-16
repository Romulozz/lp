package upeu.edu.pe.lp.app.service;

import upeu.edu.pe.lp.app.domain.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {
    private List<ItemCart> itemCarts;
    private HashMap<Integer,ItemCart> itemCartHashMap;

    public CartService(){
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    //Metodo que agrega un nuevo producto y actualiza en paralelo el fillList
    public void addItemCart(Integer idProduct, String nameProduct, Integer quantity, BigDecimal price){
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(),itemCart);
        fillList();
    }

    //Metodo que calcula el total del carrito
    public BigDecimal getTotalCart(){
        BigDecimal total =  BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts){
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }

    //Metodo que elimina un producto agregado
    public void removeItemCart(Integer idProduct){
        itemCartHashMap.remove(idProduct);
        fillList();
    }

    //Metodo que agrega en un forEach los item cart
    private void fillList(){
        itemCarts.clear();
        itemCartHashMap.forEach(
                ((integer, itemCart) -> itemCarts.add(itemCart))
        );
    }

    //Metodo que limpia el carrito al procesar la orden
    public void removeAllItemCart(){
        itemCartHashMap.clear();
        itemCarts.clear();
    }
}
