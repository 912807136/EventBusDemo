# EventBusDemo
EventBus是一款针对Android优化的发布/订阅事件总线。主要功能是替代Intent,Handler,BroadCast在Fragment，Activity，Service，线程之间传递消息.优点是开销小，代码更优雅

注册和接收消息
```java
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EventBus.getDefault().register(this);
		
	}
	
	public void startSecondActivity(View view){
		startActivity(new Intent(this,SecondActivity.class));
	}
	
	public void onEvent(Object object){
		String string = (String) object;
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
```

发送消息：
```java
EventBus.getDefault().post("我很好");
```
