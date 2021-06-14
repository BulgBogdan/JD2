package bogdan.hql;

import bogdan.hql.realization.Realization;


public class App {
    public static void main(String[] args) {
        Realization realization = new Realization();
        // create shops and sellers
//        realization.createShopAndSellers(10);
        // show with jpql
//        realization.showShopsAndSellers();
        // show more 1000
//        realization.showMoreThousands();
        // show with date
//        realization.showSellersWithDate();
        // show shops with last name
        realization.showShopssWithLastName();


    }
}
