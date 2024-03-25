package iet.jxufe.cn.myapp.youwanhefei;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import iet.jxufe.cn.myapp.R;

public class SceneryActivity extends AppCompatActivity {
	int[] images = new int[] { R.drawable.tengwangge,
			R.drawable.badashanrenjinianguan, R.drawable.hanwangfeng,
			R.drawable.xiangshangongyuan, R.drawable.xishanwanshougong,
			R.drawable.meiling };
	String[] names = new String[] { "三河古镇", "李鸿章故居", "逍遥津公园"};
	String[] briefs = new String[] { "荟萃了八古景观的水乡古镇", "合肥现存规模最大、最完整的名人故居",
			"合肥市的老牌公园，合肥市必去景点之一"};
	String[] contents = new String[] {
			"\t\t三河古镇是一座典型的水乡古镇，因丰乐河、杭埠河、小南河三水交汇而得名。\n" +
					"·古镇内荟萃了丰富的人文景观，具有典型的“小桥流水人家，水乡古镇特色”。\n" +
					"·集合了古河、古桥、古圩、古街巷、古茶楼、古民居、古庙台、古战场，江淮地区独有的八古景观。\n" +
					"·这里远在春秋战国时期便已初具雏形，素有“游在黄山，食在三河”之誉。",
			"\t\t·是晚清军政大臣李鸿章的家宅，为典型的晚清江淮地区民居建筑，是合肥仅存的规模最大的名人故居。\n" +
					"·故居的建筑由南到北依次为大门、前厅、中厅、走马楼，木雕精美，各厅堂中布满李鸿章的展览。\n" +
					"·走马楼是整个故居的精华，为“回”字型木楼，一楼有“李鸿章与招商局”展览，二楼是小姐们的闺房。\n" +
					"·故居主体建筑的东侧是陈列馆，介绍李鸿章领导的淮军，陈列着当时淮军的铠甲，还有五色圣旨等。",
			"\t\t·明清时期逍遥津公园曾是官僚地主的私家花园，以水系自然的分为东西两园。\n" +
					"·园内景点密集，东园为青少年活动区和儿童乐园，丰富多样的娱乐设施，特别适合亲子旅游。\n" +
					"·西园则以植物造景为主，有梅花山、牡丹园、杜鹃园等，还有各种奇花异草、楼台亭阁等。" };

	private ListView myList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scenery);
		myList = (ListView) findViewById(R.id.sceneryList);
		ArrayList<Map<String, String>> sceneryList = new ArrayList<Map<String, String>>();
		for (int i = 0; i < names.length; i++) {
			Map<String, String> sceneryItem = new HashMap<String, String>();
			sceneryItem.put("name", names[i]);
			sceneryItem.put("brief", briefs[i]);
			sceneryItem.put("image", images[i] + "");
			sceneryList.add(sceneryItem);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, sceneryList,
				R.layout.scenery_item,
				new String[] { "image", "name", "brief" }, new int[] {
				R.id.image, R.id.name, R.id.brief });
		myList.setAdapter(adapter);
		myList.setOnItemClickListener(new myOnItemClickListener());

	}
	private class myOnItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
								long id) {
			Intent intent = new Intent();
			intent.setClass(SceneryActivity.this, SceneryShowActivity.class);
			intent.putExtra("image", images[position]);
			intent.putExtra("content", contents[position]);
			startActivity(intent);
		}
	}
}