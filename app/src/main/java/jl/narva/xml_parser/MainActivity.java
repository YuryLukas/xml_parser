package jl.narva.xml_parser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.mainlist);
        try {
            GetXmlData getXmlData = new GetXmlData("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
            //CurrencyDataParser currencyDataParser = new CurrencyDataParser(getXmlData.getData());
           // currencyDataParser.parse();
            //ArrayList<ExchangeRates> ratesArrayList = currencyDataParser.getRatesArrayList();
            //for(ExchangeRates item: ratesArrayList ){
              //  this.add(item.getCurrency(), item.getRate());
           // }
        } catch (IOException /*| XmlPullParserException*/ e) {
            e.printStackTrace();
        }
    }

    public void add(String currencyName, String rate){
        TextView currency;
        TextView rateText;
        LinearLayout line;

        currency = new TextView(this);
        currency.setText(currencyName);
        rateText = new TextView(this);
        rateText.setText(rate);
        line = new LinearLayout(this);
        line.setOrientation(LinearLayout.HORIZONTAL);
        line.addView(currency);
        line.addView(rateText);
        linearLayout.addView(line);
    }
}