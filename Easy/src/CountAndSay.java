
public class CountAndSay {

	public String countAndSay_1(int n) {
		StringBuilder curr=new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;

		for (int i=1;i<n;i++){
			prev=curr;
			curr=new StringBuilder();       
			count=1;
			say=prev.charAt(0);

			for (int j=1,len=prev.length();j<len;j++){
				if (prev.charAt(j)!=say){
					curr.append(count).append(say);
					count=1;
					say=prev.charAt(j);
				}
				else count++;
			}
			curr.append(count).append(say);
		}	

		return curr.toString();
	}

	public String countAndSay_2(int n) {
		if(n <= 0) return "-1";
		String result = "1";

		for(int i = 1; i < n; i ++) {
			result = build(result);
		}
		return result;
	}

	private String build(String result) {
		StringBuilder builder = new StringBuilder();
		int p = 0;
		while(p < result.length()) {
			char val = result.charAt(p);
			int count = 0;

			while(p < result.length() && 
					result.charAt(p) == val){
				p ++;
				count ++;
			}
			builder.append(String.valueOf(count));
			builder.append(val);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		CountAndSay test = new CountAndSay();
		System.out.println(test.countAndSay_2(10));
	}

}
