import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String jump = "";
		while ((br.readLine()) != null) {
			String[] split = br.readLine().split(" ");
			int[] prices = new int[split.length];
			for (int i = 0; i < split.length; i++) {
				prices[i] = Integer.valueOf(split[i]);
			}
			int m = Integer.valueOf(br.readLine());
			Arrays.sort(prices);
			boolean midpoint = false;
			int bookPrice = 0;
			for (int i = 0; i < prices.length && !midpoint; i++) {
				if (prices[i] <= m/2) {
					int index = Arrays.binarySearch(prices, m-prices[i]);
					if (index != -1 && index != i) {
						bookPrice = prices[i];
					}
				}
				else
					midpoint = true;
			}
			System.out.println(jump+"Peter should buy books whose prices are "+bookPrice+" and "+(m-bookPrice)+".");
			jump = "\n";
			br.readLine();
		}
		br.close();
	}
}