package com.vaadin.tutorial.crm.backend.library.base.embeddable.productUsability;

public enum ProductUsability {
    RESTAURANT("Étteremi", "Restaurant"),
    DELIVERY("Házhozszállításra", "Delivery");
    public final String hu;
    public final String en;

    private ProductUsability(String hu, String en) {
        this.hu = hu;
        this.en = en;
    }
}
