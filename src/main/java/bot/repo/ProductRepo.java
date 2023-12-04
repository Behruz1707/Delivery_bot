package bot.repo;

import bot.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    public static final List<Product> PRODUCT_LIST = new ArrayList<>();

    static {
        PRODUCT_LIST.addAll(List.of(
                Product.builder()
                        .id(1)
                        .name("Classic burger")
                        .description("Soft bun, tender chicken fillet (Halal), fresh tomatoes, pickled cucumbers, salad leaves, mayonnaise and ketchup sauces\n\n")
                        .price(22000F).build(),
                Product.builder()
                        .id(2)
                        .name("Chicken-cheese")
                        .description("Soft bun, juicy chicken cutlet (Halal), cheddar cheese, fresh tomatoes, iceberg lettuce, mayonnaise and ketchup sauces\n\n")
                        .price(23000F).build(),
                Product.builder()
                        .id(3)
                        .name("Barbeque burger")
                        .description("Soft bun,juicy chucken cutlet (Halal) in author’s breading, fresh tomatoes, Iceberg lettuce, mayonnaise and BBQ sauce\n\n")
                        .price(24000F).build(),
                Product.builder()
                        .id(4)
                        .name("Double chicken-cheese")
                        .description("Soft bun,two juicy chucken cutlets (Halal), cheddar cheese, fresh tomatoes, pickles, iceberg lettuce, mayonnaise and ketchup\n\n")
                        .price(30000F).build(),
                Product.builder()
                        .id(5)
                        .name("Caesar")
                        .description("Сhicken fillet (Halal), Parmesan cheese, cherry tomaotes, croutons, iceberg lettuce, caesar sauce\n\n")
                        .price(26000F).build(),
                Product.builder()
                        .id(6)
                        .name("Greek")
                        .description("Salad of juicy lettuce leaves, tomatoes, olives, fresh cucumbers and fetax cheese, seasoned with lemon and basil sauce\n\n")
                        .price(25000F)
                        .build(),
                Product.builder()
                        .id(7)
                        .name("Sesame")
                        .description("Iceberg lettuce, chicken fillet, served with seeds and Teriyaki sauce\n\n")
                        .price(22000F)
                        .build(),
                Product.builder()
                        .id(8)
                        .name("Montella")
                        .description("\n\n")
                        .price(3000F)
                        .build(),
                Product.builder()
                        .id(9)
                        .name("Fanta")
                        .description("\n\n")
                        .price(8000F)
                        .build(),
                Product.builder()
                        .id(10)
                        .name("Sprite")
                        .description("\n\n")
                        .price(8000F)
                        .build()
        ));

    }


    public static Product getById(long id) throws Exception {
        return PRODUCT_LIST.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("Product not found with id - " + id)
                );
    }
}
