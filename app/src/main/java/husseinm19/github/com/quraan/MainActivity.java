package husseinm19.github.com.quraan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hussein on 14/04/2020.
 */

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
//    ArrayList<ExampleItem> exampleList = new ArrayList<>();
      List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           forceRTLIfSupported();
            createExampleList();
            buildRecyclerView();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);

                return false;
            }
        });

        return true;
    }

    public void createExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem( "الفاتحه"," سُّورَة مَكيَّة" ,"elfatha.pdf"));
        exampleList.add(new ExampleItem( "البقره", "سُّورَة مَدنيَّة" ,"elbakrah.pdf"));
        exampleList.add(new ExampleItem( "آل عمران", "سُّورَة مَدنيَّة" ,"alomran.pdf"));
        exampleList.add(new ExampleItem( "النساء",  "سُّورَة مَدنيَّة" ,"alnsaa.pdf"));
        exampleList.add(new ExampleItem( "المائده", "سُّورَة مَدنيَّة" ,"almaadh.pdf"));
        exampleList.add(new ExampleItem( "الأنعام", "سُّورَة مَكيَّة" ,"alanaam.pdf"));
        exampleList.add(new ExampleItem( "الأعراف", "سُّورَة مَكيَّة" ,"alaaraf.pdf"));
        exampleList.add(new ExampleItem( "الأنفال", "سُّورَة مَدنيَّة" ,"alanfal.pdf"));
        exampleList.add(new ExampleItem( "التوبه", "سُّورَة مَدنيَّة" ,"altwbah.pdf"));
        exampleList.add(new ExampleItem( "يونس", "سُّورَة مَكيَّة" ,"younis.pdf"));
        exampleList.add(new ExampleItem( "هود", "سُّورَة مَكيَّة" ,"hood.pdf"));
        exampleList.add(new ExampleItem( "يوسف", "سُّورَة مَكيَّة" ,"yousef.pdf"));
        exampleList.add(new ExampleItem( "الرعد", "سُّورَة مَدنيَّة" ,"elraad.pdf"));
        exampleList.add(new ExampleItem( "ابراهيم", "سُّورَة مَكيَّة" ,"ibrahim.pdf"));
        exampleList.add(new ExampleItem( "الحجر", "سُّورَة مَكيَّة" ,"elhagr.pdf"));
        exampleList.add(new ExampleItem( "النخل", "سُّورَة مَكيَّة" ,"elnahl.pdf"));
        exampleList.add(new ExampleItem( "الاسراء", "سُّورَة مَكيَّة" ,"esraa.pdf"));
        exampleList.add(new ExampleItem( "الكهف", "سُّورَة مَكيَّة" ,"kahf.pdf"));
        exampleList.add(new ExampleItem( "مريم", "سُّورَة مَكيَّة" ,"marim.pdf"));
        exampleList.add(new ExampleItem( "طه", "سُّورَة مَكيَّة" ,"taha.pdf"));
        exampleList.add(new ExampleItem( "الأنبياء", "سُّورَة مَكيَّة" ,"anbyaa.pdf"));
        exampleList.add(new ExampleItem( "الحج", "سُّورَة مَدنيَّة" ,"elhag.pdf"));
        exampleList.add(new ExampleItem( "المؤمونين", "سُّورَة مَكيَّة" ,"moamnoon.pdf"));
        exampleList.add(new ExampleItem( "النور", "سُّورَة مَدنيَّة" ,"noor.pdf"));
        exampleList.add(new ExampleItem( "الفرقان", "سُّورَة مَكيَّة" ,"forqan.pdf"));
        exampleList.add(new ExampleItem( "الشعراء", "سُّورَة مَكيَّة" ,"shoaraa.pdf"));
        exampleList.add(new ExampleItem( "النمل", "سُّورَة مَكيَّة" ,"naml.pdf"));
        exampleList.add(new ExampleItem( "القصص", "سُّورَة مَكيَّة" ,"qss.pdf"));
        exampleList.add(new ExampleItem( "العنكبوت", "سُّورَة مَكيَّة" ,"ankboot.pdf"));
        exampleList.add(new ExampleItem( "الروم", "سُّورَة مَكيَّة" ,"room.pdf"));
        exampleList.add(new ExampleItem( "لقمان", "سُّورَة مَكيَّة" ,"loqman.pdf"));
        exampleList.add(new ExampleItem( "السجده", "سُّورَة مَكيَّة" ,"sajdah.pdf"));
        exampleList.add(new ExampleItem( "الأحزاب", "سُّورَة مَدنيَّة" ,"ahzab.pdf"));
        exampleList.add(new ExampleItem( "سبأ", "سُّورَة مَكيَّة" ,"sbaa.pdf"));
        exampleList.add(new ExampleItem( "فاطر", "سُّورَة مَكيَّة" ,"fater.pdf"));
        exampleList.add(new ExampleItem( "يس", "سُّورَة مَكيَّة" ,"yaseen.pdf"));
        exampleList.add(new ExampleItem( "الصافات", "سُّورَة مَكيَّة" ,"safat.pdf"));
        exampleList.add(new ExampleItem( "ص", "سُّورَة مَكيَّة" ,"s.pdf"));
        exampleList.add(new ExampleItem( "الزمر", "سُّورَة مَكيَّة" ,"zomr.pdf"));
        exampleList.add(new ExampleItem( "غافر", "سُّورَة مَكيَّة" ,"ghafr.pdf"));
        exampleList.add(new ExampleItem( "فصلت", "سُّورَة مَكيَّة" ,"faslt.pdf"));
        exampleList.add(new ExampleItem( "الشورى", "سُّورَة مَكيَّة" ,"shory.pdf"));
        exampleList.add(new ExampleItem( "الزحرف", "سُّورَة مَكيَّة" ,"elzakhrf.pdf"));
        exampleList.add(new ExampleItem( "الدخان", "سُّورَة مَكيَّة" ,"eldkhan.pdf"));
        exampleList.add(new ExampleItem( "الجاثيه", "سُّورَة مَكيَّة" ,"elgathya.pdf"));
        exampleList.add(new ExampleItem( "الأحقاف", "سُّورَة مَكيَّة" ,"elahqaaf.pdf"));
        exampleList.add(new ExampleItem( "محمد", "سُّورَة مَدنيَّة" ,"mohamed.pdf"));
        exampleList.add(new ExampleItem( "الفتح", "سُّورَة مَدنيَّة" ,"elfath.pdf"));
        exampleList.add(new ExampleItem( "الحجرات", "سُّورَة مَدنيَّة" ,"elhograt.pdf"));
        exampleList.add(new ExampleItem( "ق", "سُّورَة مَكيَّة" ,"q.pdf"));
        exampleList.add(new ExampleItem( "الذاريات", "سُّورَة مَكيَّة" ,"elzoryat.pdf"));
        exampleList.add(new ExampleItem( "الطور", "سُّورَة مَكيَّة" ,"eltoor.pdf"));
        exampleList.add(new ExampleItem( "النجم", "سُّورَة مَكيَّة" ,"elnegm.pdf"));
        exampleList.add(new ExampleItem( "القمر", "سُّورَة مَكيَّة" ,"elqamr.pdf"));
        exampleList.add(new ExampleItem( "الرحمن", "سُّورَة مَدنيَّة" ,"elrahmn.pdf"));
        exampleList.add(new ExampleItem( "الواقعه", "سُّورَة مَكيَّة" ,"elwaqaa.pdf"));
        exampleList.add(new ExampleItem( "الحديد", "سُّورَة مَدنيَّة" ,"elhadid.pdf"));
        exampleList.add(new ExampleItem( "المجادله", "سُّورَة مَدنيَّة" ,"elmogadla.pdf"));
        exampleList.add(new ExampleItem( "الحشر", "سُّورَة مَدنيَّة" ,"elhashr.pdf"));
        exampleList.add(new ExampleItem( "الممتحنه", "سُّورَة مَدنيَّة" ,"elmomtahna.pdf"));
        exampleList.add(new ExampleItem( "الصف", "سُّورَة مَدنيَّة" ,"elsaf.pdf"));
        exampleList.add(new ExampleItem( "الجمعه", "سُّورَة مَدنيَّة" ,"elgomaa.pdf"));
        exampleList.add(new ExampleItem( "المنافقون", "سُّورَة مَدنيَّة" ,"elmonafqoon.pdf"));
        exampleList.add(new ExampleItem( "التغابن", "سُّورَة مَدنيَّة" ,"eltghabeen.pdf"));
        exampleList.add(new ExampleItem( "الطلاق", "سُّورَة مَدنيَّة" ,"eltlaq.pdf"));
        exampleList.add(new ExampleItem( "التحريم", "سُّورَة مَدنيَّة" ,"eltahreem.pdf"));
        exampleList.add(new ExampleItem( "الملك", "سُّورَة مَكيَّة" ,"elmalak.pdf"));
        exampleList.add(new ExampleItem( "القلم", "سُّورَة مَكيَّة" ,"elqalm.pdf"));
        exampleList.add(new ExampleItem( "الحاقه", "سُّورَة مَكيَّة" ,"elhaqa.pdf"));
        exampleList.add(new ExampleItem( "المعارج", "سُّورَة مَكيَّة" ,"elmaarg.pdf"));
        exampleList.add(new ExampleItem( "نوح", "سُّورَة مَكيَّة" ,"noh.pdf"));
        exampleList.add(new ExampleItem( "الجن", "سُّورَة مَكيَّة" ,"elgen.pdf"));
        exampleList.add(new ExampleItem( "المزمل", "سُّورَة مَكيَّة" ,"elmazml.pdf"));
        exampleList.add(new ExampleItem( "المدثر", "سُّورَة مَكيَّة" ,"elmadthr.pdf"));
        exampleList.add(new ExampleItem( "القيامه", "سُّورَة مَكيَّة" ,"elqyama.pdf"));
        exampleList.add(new ExampleItem( "الانسان", "سُّورَة مَدنيَّة" ,"elansan.pdf"));
        exampleList.add(new ExampleItem( "المرسلات", "سُّورَة مَكيَّة" ,"elmorslat.pdf"));
        exampleList.add(new ExampleItem( "النبأ", "سُّورَة مَكيَّة" ,"elnabaa.pdf"));
        exampleList.add(new ExampleItem( "النازعات", "سُّورَة مَكيَّة" ,"elnazaat.pdf"));
        exampleList.add(new ExampleItem( "عبس", "سُّورَة مَكيَّة" ,"eebs.pdf"));
        exampleList.add(new ExampleItem( "النكوير", "سُّورَة مَكيَّة" ,"eltakweer.pdf"));
        exampleList.add(new ExampleItem( "الانفطار", "سُّورَة مَكيَّة" ,"elinftar.pdf"));
        exampleList.add(new ExampleItem( "المطففين", "سُّورَة مَكيَّة" ,"elmotffeen.pdf"));
        exampleList.add(new ExampleItem( "الأنشقاق", "سُّورَة مَكيَّة" ,"elanshqaq.pdf"));
        exampleList.add(new ExampleItem( "البروج", "سُّورَة مَكيَّة" ,"elbrooj.pdf"));
        exampleList.add(new ExampleItem( "الطارق", "سُّورَة مَكيَّة" ,"eltarek.pdf"));
        exampleList.add(new ExampleItem( "الأعلى", "سُّورَة مَكيَّة" ,"elaalaa.pdf"));
        exampleList.add(new ExampleItem( "الغاشيه", "سُّورَة مَكيَّة" ,"elghashya.pdf"));
        exampleList.add(new ExampleItem( "الفجر", "سُّورَة مَكيَّة" ,"elfagr.pdf"));
        exampleList.add(new ExampleItem( "البلد", "سُّورَة مَكيَّة" ,"elbalad.pdf"));
        exampleList.add(new ExampleItem( "الشمس", "سُّورَة مَكيَّة" ,"elshams.pdf"));
        exampleList.add(new ExampleItem( "الليل", "سُّورَة مَكيَّة" ,"elleel.pdf"));
        exampleList.add(new ExampleItem( "الضحى", "سُّورَة مَكيَّة" ,"eldoha.pdf"));
        exampleList.add(new ExampleItem( "الشرح", "سُّورَة مَكيَّة" ,"elsharh.pdf"));
        exampleList.add(new ExampleItem( "التين", "سُّورَة مَكيَّة" ,"elteen.pdf"));
        exampleList.add(new ExampleItem( "العلق", "سُّورَة مَكيَّة" ,"elalaq.pdf"));
        exampleList.add(new ExampleItem( "القدر", "سُّورَة مَكيَّة" ,"elqadr.pdf"));
        exampleList.add(new ExampleItem( "البينه", "سُّورَة مَدنيَّة" ,"elbayna.pdf"));
        exampleList.add(new ExampleItem( "الزلزله", "سُّورَة مَدنيَّة" ,"elzlzla.pdf"));
        exampleList.add(new ExampleItem( "العاديات", "سُّورَة مَكيَّة" ,"eladyat.pdf"));
        exampleList.add(new ExampleItem( "القارعه", "سُّورَة مَكيَّة" ,"elqaraa.pdf"));
        exampleList.add(new ExampleItem( "التكاثر", "سُّورَة مَكيَّة" ,"eltakathor.pdf"));
        exampleList.add(new ExampleItem( "العصر", "سُّورَة مَكيَّة" ,"elasr.pdf"));
        exampleList.add(new ExampleItem( "الهمزه", "سُّورَة مَكيَّة" ,"elhamzha.pdf"));
        exampleList.add(new ExampleItem( "الفيل", "سُّورَة مَكيَّة" ,"elfeel.pdf"));
        exampleList.add(new ExampleItem( "قريش", "سُّورَة مَكيَّة" ,"qorysh.pdf"));
        exampleList.add(new ExampleItem( "الماعون", "سُّورَة مَكيَّة" ,"elmaaon.pdf"));
        exampleList.add(new ExampleItem( "الكوثر", "سُّورَة مَكيَّة" ,"elkawther.pdf"));
        exampleList.add(new ExampleItem( "الكافرون", "سُّورَة مَكيَّة" ,"elkafroon.pdf"));
        exampleList.add(new ExampleItem( "النصر", "سُّورَة مَدنيَّة" ,"elnasr.pdf"));
        exampleList.add(new ExampleItem( "المسد", "سُّورَة مَكيَّة" ,"elmasd.pdf"));
        exampleList.add(new ExampleItem( "الاخلاص", "سُّورَة مَكيَّة" ,"elakhlas.pdf"));
        exampleList.add(new ExampleItem( "الفلق", "سُّورَة مَكيَّة" ,"elfalq.pdf"));
        exampleList.add(new ExampleItem( "الناس", "سُّورَة مَكيَّة" ,"elnas.pdf"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, exampleList.get(position).getText1(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), PdfActivity.class);
                intent.putExtra("id",exampleList.get(position).getpdf() );
                intent.putExtra("name",exampleList.get(position).getText1());
                startActivity(intent);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void forceRTLIfSupported()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
    }
}
