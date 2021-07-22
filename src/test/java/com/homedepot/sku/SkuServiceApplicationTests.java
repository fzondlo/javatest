package com.homedepot.sku;
​
import com.homedepot.sku.dto.Sku;
import com.homedepot.sku.service.SkuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
​
import java.util.List;
​
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
​
@SpringBootTest
class SkuServiceApplicationTests {
​
	@Autowired
	SkuService skuService;
​
	@Test
	void contextLoads() {
	}
​
	// TODO -- TEST getSkuDetails returns valid response for valid SKU's
	@Test
	public void whenGetSkuDetailReturnsValidResponse(){
​
		List<Integer> skus = List.of(111111);
​
		List<Sku> skuList = skuService.getSkuDetails(skus);
​
		assertThat(skuList).isNotNull();
		assertThat(skuList.size()).isEqualTo(1);
​
		Sku sku = skuList.get(0);
		assertThat(sku.getMVendorNumber()).isEqualTo(101010);
		assertThat(sku.getRetail()).isEqualTo(100);
		assertThat(sku.getSkuDescription()).isEqualTo("SKU 111111");
		assertThat(sku.getSkuNumber()).isEqualTo(111111);
	}
​
	// TODO -- TEST getSkuDetails returns empty response for invalid SKU's
	@Test
	public void whenGetSkuDetailsReturnsEmptyResponse(){
​
		List<Integer> skus = List.of(1234);
​
		List<Sku> skuList = skuService.getSkuDetails(skus);
​
		assertThat(skuList).isNotNull();
		assertThat(skuList.size()).isEqualTo(0);
	}
​
​
	// TODO -- TEST updateSkuRetail updates correct retail for valid SKU / MVENDOR combo
	@Test
	public void whenUpdateSkuRetailUpdatesCorrectly(){
​
		Sku sku = new Sku("SKU 111111", 111111, 101010, 110);
​
		List<Sku> skuList = skuService.updateSkuRetail(List.of(sku));
​
		assertThat(skuList).isNotNull();
		assertThat(skuList.size()).isEqualTo(1);
​
		Sku updatedSku = skuList.get(0);
		assertThat(updatedSku.getMVendorNumber()).isEqualTo(101010);
		assertThat(updatedSku.getRetail()).isEqualTo(110);
		assertThat(updatedSku.getSkuDescription()).isEqualTo("SKU 111111");
		assertThat(updatedSku.getSkuNumber()).isEqualTo(111111);
	}
​
	// TODO -- TEST updateSkuRetail returns empty response for invalid SKU / MVENDOR combo
	@Test
	public void whenUpdateSkuRetailReturnsEmptyResponseWithInvalidSku(){
​
		Sku sku = new Sku("SKU 111111", 1234, 101010, 110);
​
		List<Sku> skuList = skuService.updateSkuRetail(List.of(sku));
​
		assertThat(skuList).isNotNull();
		assertThat(skuList.size()).isEqualTo(0);
	}
}
