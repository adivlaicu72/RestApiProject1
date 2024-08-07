import org.testng.annotations.Test;

import io.restassured.response.Response;
import testdata.DataBuilder;
import utils.BaseComponent4;

public class BaseComponent4Test extends BaseComponent4{

	@Test
	public void postTodoWithToken() {
		
		Response response = doRequest("POST","save", DataBuilder.buildToDo().toJSONString());
		
		System.out.println(response.asPrettyString());
	}
}
