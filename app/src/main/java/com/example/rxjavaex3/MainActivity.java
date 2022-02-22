package com.example.rxjavaex3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    ArrayList<CoinsData> coinsDataArrayList = new ArrayList<>();
    Adapter adapter;
    Disposable d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting the layout as linear
        // layout for vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        Observable.just(coinsDataArrayList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<ArrayList<CoinsData>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                        d=disposable;
                    }

                    @Override
                    public void onNext(@NonNull ArrayList<CoinsData> coinsData) {
                        adapter = new Adapter(coinsDataArrayList,MainActivity.this);

                        recyclerView.setAdapter(adapter);


                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        populateData();


    }


    private void populateData(){

        coinsDataArrayList.add(new CoinsData("Bitcoin","https://logos-download.com/wp-content/uploads/2016/06/Bitcoin_logo_yellow.png",3056857.35));
        coinsDataArrayList.add(new CoinsData("Ethereum ","https://azcoinnews.com/wp-content/uploads/2020/06/ethereum-wallets-with-at-least-32-eth-the-amount-required-for-eth-2-0-staking-have-grown-by-13-this-year.jpg",214052.93	));
        coinsDataArrayList.add(new CoinsData("1Inch","https://th.bing.com/th/id/OIP.lb8G1RPteuLqfuJFeo2vkQHaHa?pid=ImgDet&rs=1",117.46));
        coinsDataArrayList.add(new CoinsData("Polygon","https://th.bing.com/th/id/OIP.fikNVzNdG6_s2OBUCjt2kAHaEK?pid=ImgDet&rs=1",122.12));
        coinsDataArrayList.add(new CoinsData("Solana","https://th.bing.com/th/id/OIP.TePcpwLE3VdyrywRA2j2UQHaEL?pid=ImgDet&rs=1",7055.35));
        coinsDataArrayList.add(new CoinsData("Flow","https://th.bing.com/th/id/OIP.hwwn-1hXbEkm-NI2NXR1GwHaFj?pid=ImgDet&rs=1",452.23));
        coinsDataArrayList.add(new CoinsData("Fantom","https://www.cryptonewsz.com/wp-content/uploads/2019/05/fantom.jpeg",136.55));
        coinsDataArrayList.add(new CoinsData("Litecoin","https://coinsutra.com/wp-content/uploads/2017/06/Litecoin-Cryptocurrency.jpg",8755.48));
        coinsDataArrayList.add(new CoinsData("Terra","https://i0.wp.com/blockpublisher.com/wp-content/uploads/2019/01/201808306c2f87507f8907f57.png?resize=650%2C320&ssl=1",4229.65));
        coinsDataArrayList.add(new CoinsData("Dash","https://th.bing.com/th/id/OIP.skqquIToiqFnsJJWjWm-agHaE0?pid=ImgDet&rs=1",7602.26));
        coinsDataArrayList.add(new CoinsData("Zcash","https://th.bing.com/th/id/OIP.SEeQFy2whFXtZuXQBHDVJQAAAA?pid=ImgDet&rs=1",8660.65));
        coinsDataArrayList.add(new CoinsData("Maker","https://en.bitcoinwiki.org/upload/en/images/thumb/9/98/Maker.jpg/400px-Maker.jpg  ",140000.59));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d.dispose();
    }
}