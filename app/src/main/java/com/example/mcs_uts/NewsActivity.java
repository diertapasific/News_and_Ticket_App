package com.example.mcs_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements NewsInterface {
    BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerViewHorizontal, recyclerViewVertical;
    LinearLayoutManager linearLayoutManager, linearLayoutManager2;
    NewsHorizontalAdapter NewsHorizontalAdapter;
    NewsVerticalAdapter newsVerticalAdapter;
    static List<NewsHorizontal> newsHorizontals;
    static List<NewsVertical> newsVerticals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_custom);
        }

        recyclerViewHorizontal = findViewById(R.id.newsHorizontalRV); newsHorizontals = new ArrayList<NewsHorizontal>();
        newsHorizontals.add(new NewsHorizontal("Sainz admits he’s in “damage limitation” mode...","29 Apr 2023","Sainz admits he’s in “damage limitation” mode as he lacks confidence in car","His Ferrari team mate Charles Leclerc took pole position for the race – his second in as many days as he will also start tomorrow’s grand prix from the front. However Sainz lagged over half a second behind the team’s other car in both this weekend’s qualifying sessions.\n\n" +
                "“I have an explanation why, I clearly don’t feel comfortable and confident,” Sainz said after today’s sprint race. “If I would then I would just be lacking three tenths, half a second per lap. But I clearly don’t have the confidence.”", R.drawable.image_news_1));
        newsHorizontals.add(new NewsHorizontal("Leclerc encouraged by clear Ferrari ‘step forward’...","30 Apr 2023","Leclerc encouraged by clear Ferrari ‘step forward’ despite losing out to Perez in Baku Sprint","Charles Leclerc hailed significant progress in the Ferrari camp after he managed to split Red Bull pair Sergio Perez and Max Verstappen and claim second position during Saturday’s Sprint race at the Baku City Circuit.\n" +
                "\n" +
                "Leclerc started the 17-lap dash on pole position, having topped both qualifying sessions this weekend, but was overhauled by Perez shortly after a Safety Car restart – the Red Bull’s superior DRS-assisted straight-line speed on show again.", R.drawable.image_news_2));
        newsHorizontals.add(new NewsHorizontal("Leclerc says Ferrari 'absolutely maximised'...","30 Apr 2023","Leclerc says Ferrari 'absolutely maximised' Azerbaijan weekend after claiming first podium of season","Charles Leclerc secured his first podium of the season in the 2023 Azerbaijan Grand Prix, after taking pole in the Sprint Shootout and pole for the Grand Prix, and while he said Ferrari got the best result possible, he admitted there was more to be done.\n" +
                "\n" +
                "The Ferrari driver led the Red Bulls off the line on Sunday in Baku but Max Verstappen and Sergio Perez eventually breezed past Leclerc and it was Perez who won the race. Leclerc did however take his first podium – plus P2 in the Sprint – to take 22 points and jump up to sixth in the drivers’ standings.", R.drawable.image_news_3));
        linearLayoutManager = new LinearLayoutManager(NewsActivity.this, LinearLayoutManager.HORIZONTAL,false);
        NewsHorizontalAdapter = new NewsHorizontalAdapter(this, newsHorizontals, this);
        recyclerViewHorizontal.setLayoutManager(linearLayoutManager);
        recyclerViewHorizontal.setAdapter(NewsHorizontalAdapter);



        recyclerViewVertical = findViewById(R.id.newsVerticalRV);
        newsVerticals = new ArrayList<NewsVertical>();
        newsVerticals.add(new NewsVertical("Perez heads Red Bull one-two in dramatic Azerbaijan GP...","30 Apr 2023","Sergio Perez doubled up on the streets of Baku by adding to his Sprint race triumph with victory...", "Perez heads Red Bull one-two in dramatic Azerbaijan GP to cut Verstappen’s championship lead","Sergio Perez doubled up on the streets of Baku by adding to his Sprint race triumph with victory in Sunday’s drama-filled Azerbaijan Grand Prix, leading Red Bull team mate Max Verstappen and Ferrari’s Charles Leclerc home to boost his title push.\n" +
                "\n" +
                "Verstappen and Perez overhauled pole-sitter Leclerc in the early stages and proceeded to trade fastest lap times at the head of the field, with the defining moment of the race coming when a Safety Car was deployed either side of the Red Bull drivers pitting.", R.drawable.image_news_4));
        newsVerticals.add(new NewsVertical("‘I learned a lot of things’ – Verstappen takes the positives...","30 Apr 2023", "Although he was naturally disappointed not to claim victory in the Azerbaijan Grand Prix, Max Verstappen feels...","‘I learned a lot of things’ – Verstappen takes the positives from Baku despite losing out to team mate Perez","Although he was naturally disappointed not to claim victory in the Azerbaijan Grand Prix, Max Verstappen feels he gathered plenty of valuable information about his Red Bull that will aid his cause moving forward.\n" +
                "\n" +
                "Verstappen led the early stages of Sunday’s race from team mate Sergio Perez and Ferrari’s Charles Leclerc, but dropped back to third due to the timing of a Safety Car and was forced into a recovery drive.", R.drawable.image_news_5));
        newsVerticals.add(new NewsVertical("'Ferrari were quite lucky' declares Alonso...","30 Apr 2023","It was Fernando Alonso and Aston Martin’s first race that ended with them off the podium, as the Spaniard...","'Ferrari were quite lucky' declares Alonso as he narrowly misses out on podium finish at Azerbaijan GP","It was Fernando Alonso and Aston Martin’s first race that ended with them off the podium, as the Spaniard and his team mate Lance Stroll took the chequered flag in fourth and seventh, respectively, bringing an end to a “tricky” weekend in Baku.\n" +
                "\n" +
                "Alonso started sixth and maintained that position before a Safety Car allowed him to gain an extra position ahead of Lewis Hamilton. At the restart, he moved up to fourth by pulling off a stunning overtake on compatriot Carlos Sainz.", R.drawable.image_news_6));
        newsVerticals.add(new NewsVertical("Ocon to start Azerbaijan Sprint and Grand Prix from pit lane...","29 Apr 2023","Alpine's Esteban Ocon will start Saturday evening's Sprint and Sunday afternoon's Azerbaijan Grand Prix from the pit lane...","Ocon to start Azerbaijan Sprint and Grand Prix from pit lane after Alpine make parc ferme changes","Alpine's Esteban Ocon will start Saturday evening's Sprint and Sunday afternoon's Azerbaijan Grand Prix from the pit lane after the team made changes to his car with parc ferme conditions active.\n" +
                "\n" +
                "The team encountered reliability issues on Friday as Pierre Gasly's car went up in smoke during FP1 – the sole practice session for the weekend – and then he crashed out of qualifying.", R.drawable.image_news_7));
        newsVerticals.add(new NewsVertical("AlphaTauri boss Tost explains timing of departure...","29 Apr 2023", "After AlphaTauri’s sudden announcement that Team Principal Franz Tost will step away at the end of...","AlphaTauri boss Tost explains timing of departure announcement and choice to bring Ferrari's Mekies on board","After AlphaTauri’s sudden announcement that Team Principal Franz Tost will step away at the end of the season to make way for Ferrari’s Sporting Director Laurent Mekies, Tost has explained the team’s decision to announce his impending departure – and their choice of successor.\n" +
                "\n" +
                "Tost became Team Principal of the Italian-based squad – then Toro Rosso – in 2005 after Red Bull acquired Minardi. The Austrian, now 67 years old, said his decision to depart was made two years ago. Next season, Mekies will replace him and Tost’s compatriot Peter Bayer will step in as CEO.", R.drawable.image_news_8));
        newsVerticals.add(new NewsVertical("Hamilton says Mercedes upgrades are ‘start of a new path’...","27 Apr 2023","Lewis Hamilton has elaborated on the ‘new path’ the W14 is headed in as the seven-time world...","Hamilton says Mercedes upgrades are ‘start of a new path’ in Baku but 'core' of the car will remain","Lewis Hamilton has elaborated on the ‘new path’ the W14 is headed in as the seven-time world champion sounded relaxed and cautiously optimistic as he spoke to the press ahead of the Azerbaijan Grand Prix.\n" +
                "\n" +
                "Team Principal Toto Wolff had already confirmed that Mercedes were bringing a raft of small upgrades across the coming weeks, with five races in six weekends providing plenty of opportunity for the team to continue to develop their car and take it in a new direction as they seek to close the gap on championship-leaders Red Bull.", R.drawable.image_news_9));
        newsVerticals.add(new NewsVertical("Verstappen and Russell at odds after dramatic...","29 Apr 2023","Max Verstappen and George Russell offered opposing views after coming to blows on and off the track at the Baku City Circuit on...","Verstappen and Russell at odds after dramatic first-lap Sprint skirmish in Baku","Max Verstappen and George Russell offered opposing views after coming to blows on and off the track at the Baku City Circuit on Saturday, with the first Sprint race of the season serving up plenty of drama.\n" +
                "\n" +
                "Verstappen started the 17-lap race from third on the grid but was attacked by a fast-starting Russell as the lights went out, with the pair going on to race wheel-to-wheel across the first three corners.", R.drawable.image_news_10));
        linearLayoutManager2 = new LinearLayoutManager(NewsActivity.this, LinearLayoutManager.VERTICAL,false);
        newsVerticalAdapter = new NewsVerticalAdapter(this, newsVerticals, this);
        recyclerViewVertical.setLayoutManager(linearLayoutManager2);
        recyclerViewVertical.setAdapter(newsVerticalAdapter);

        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.news);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.news:
                    return true;
                case R.id.schedule:
                    startActivity(new Intent(getApplicationContext(),ScheduleTeamActivity.class));
                    finish();
                    return true;
                case R.id.history:
                    startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                    finish();
                    return true;
            }
            return false;
        });
    }


    @Override
    public void onNewsClick(int position) {
        Intent intent = new Intent(NewsActivity.this, NewsDetailsActivity.class);

        intent.putExtra("newsTitleFullHorizontal",newsHorizontals.get(position).getNewsFullTitleHorizontal());
        intent.putExtra("newsDateHorizontal",newsHorizontals.get(position).getDateNewsHorizontal());
        intent.putExtra("newsArticleFullHorizontal",newsHorizontals.get(position).getNewsFullArticleHorizontal());
        intent.putExtra("newsImage",newsHorizontals.get(position).getNewsImageHorizontal());

        startActivity(intent);

    }

    @Override
    public void onNewsClickVertical(int position) {
        Intent intent = new Intent(NewsActivity.this, NewsDetailsActivity.class);

        intent.putExtra("newsTitleFullHorizontal",newsVerticals.get(position).getNewsFullTitleVertical());
        intent.putExtra("newsDateHorizontal",newsVerticals.get(position).getDateNewsVertical());
        intent.putExtra("newsArticleFullHorizontal",newsVerticals.get(position).getNewsFullArticleVertical());
        intent.putExtra("newsImage",newsVerticals.get(position).getNewsImageVertical());

        startActivity(intent);

    }
}