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
                        .price(30000F)
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
