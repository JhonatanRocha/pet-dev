package br.com.usjt.tcc.teste;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.usjt.tcc.model.ProductVO;

import com.google.gson.Gson;

public class ProductServerTeste {

	public static void main(String[] args) {
		try {
			new ProductServerTeste().sendPost();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendPost() throws Exception {

		String url = "http://localhost:8080/pet/products/36272923";

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		String json = createAListJsonTesteVO();

		StringEntity sEntity = new StringEntity(json, "UTF-8");
		post.setEntity(sEntity);

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}

	private String createAListJsonTesteVO() {

		ProductVO product = new ProductVO();
		product.setName("prod1");
		product.setType("Gato");
		product.setRace("Dalmata");
		product.setStage("ewe1");
		product.setSize("grande1");
		product.setScore(111);
		product.setPrice(11.2);

		ProductVO product2 = new ProductVO();
		product2.setName("prod2");
		product2.setType("Cachorro");
		product2.setRace("Pug");
		product2.setStage("auu2");
		product2.setSize("pequena2");
		product2.setScore(222);
		product2.setPrice(22.2);

		List<ProductVO> productVOs = new ArrayList<ProductVO>();
		productVOs.add(product);
		productVOs.add(product2);

		Gson gson = new Gson();
		String json = gson.toJson(productVOs);
		System.out.println(json);

		return json;
	}
}
