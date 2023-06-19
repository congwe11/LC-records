package code.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/13 14:48
 */
public class MT {


    public static void main(String[] args) {

    }

    class Product {
        int skuId;
        int groupId;

        String name;
        long num;
    }

    List<Product> existList;

    void statistics(List<Product> targetList) {

        Map<Integer, Map<Integer, Product>> productMap = new HashMap<>();
        for (Product p : existList) {
            // 判断是否存在
            Map<Integer, Product> m = new HashMap<>();
            m.put(p.groupId, p);
            productMap.put(p.skuId, m);
        }

        for (Product product : targetList) {
            if (productMap.containsKey(product.skuId)) {
                Map<Integer, Product> m = productMap.get(product.skuId);
                if (m.containsKey(product.groupId)) {
                    Product p = m.get(product.groupId);
                    p.num++;
                    m.put(product.groupId, p);
                    productMap.put(product.skuId, m);
                }

            } else if (product.num != 0){
                // 不相等加入existList
                Map<Integer, Product> m = new HashMap<>();
                m.put(product.groupId, product);
                productMap.put(product.skuId, m);
            }
        }
    }
}
