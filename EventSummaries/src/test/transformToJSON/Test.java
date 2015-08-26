package test.transformToJSON;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


public class Test {

	public static void jsonObjectTest() {
		try {
			JSONObject jsonObj = new JSONObject("{ 'name':'xiaodao','age':20}");
			String name = jsonObj.getString("name");
			System.out.println(name);
			int age = jsonObj.getInt("age");
			System.out.println(age);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void jsonArrayTest() {
		try {
			JSONArray jsonArray = new JSONArray(
					"[{'name':'xiaodao','age':20},{'name':'dadao','age':21}]");
			for (int i = 0; i < jsonArray.length(); i++) {
				String name = jsonArray.getJSONObject(i).getString("name");
				int age = jsonArray.getJSONObject(i).getInt("age");
				System.out.println("name = " + name + " , age = " + age);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void jsonArrayObjectTest() {
		try {
			String str = "{'name':'xiazdong','age':20,'book':['book1','book2']}";
			JSONObject jsonObj = new JSONObject(str);
			for (int index = 0; index < jsonObj.getJSONArray("book").length(); index++) {
				System.out.println(jsonObj.getJSONArray("book").getString(index));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}

	}

	public static void jsonStringerTest() {
		try {
			JSONStringer stringer = new JSONStringer() ;
			String str = stringer.object().key("name").value("xiaodao").key("age").value(20).endObject().toString();
			System.out.print(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void jsonStringerDemo(){
		try{
			JSONStringer js = new JSONStringer();
			JSONObject object1 = new JSONObject() ;
			
			JSONObject object2 = new JSONObject() ;
			JSONObject object3 = new JSONObject() ;
			object3.put("title", "book1").put("price", "$11") ;
			object2.put("book", object3) ;
			object2.put("author", new JSONObject().put("name", "author-1")) ;
			
			JSONObject object4 = new JSONObject() ;
			JSONObject object5 = new JSONObject() ;
			object5.put("title", "book2").put("price", "$22") ;
			object4.put("book", object5) ;
			object4.put("author", new JSONObject().put("name", "author-2")) ;
			
			JSONArray oArray = new JSONArray() ;
			oArray.put(object4).put(object2) ;
			
			object1.put("title", "BOOK") ;
			object1.put("singing", oArray) ;
			
			js.object().key("session").value(object1).endObject();
			System.out.println(js.toString()) ;
			
			PrintWriter out_txt = new PrintWriter( new FileOutputStream("1.txt") ) ;
			out_txt.println( js.toString() ) ;
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsonObjectTest();
		jsonArrayTest();
		jsonArrayObjectTest();
		jsonStringerTest();
		jsonStringerDemo(); 
	}
}
