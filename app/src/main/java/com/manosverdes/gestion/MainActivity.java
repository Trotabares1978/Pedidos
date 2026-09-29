package com.manosverdes.gestion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends android.app.Activity {
    private static final String PEDIDOS = "https://trotabares1978.github.io/Pedidos/";
    private static final String GESTION = "https://trotabares1978.github.io/Pedidos/gestion.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(28, 36, 28, 28);
        root.setBackgroundColor(Color.rgb(247, 244, 231));

        TextView title = new TextView(this);
        title.setText("MANOS VERDES");
        title.setTextColor(Color.rgb(11,61,32));
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView subtitle = new TextView(this);
        subtitle.setText("GESTIÓN");
        subtitle.setTextColor(Color.rgb(46,125,50));
        subtitle.setTextSize(22);
        subtitle.setTypeface(Typeface.DEFAULT_BOLD);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(-1, -2);
        sp.setMargins(0, 4, 0, 42);
        root.addView(subtitle, sp);

        Button pedidos = makeButton("🛒  PEDIDOS", Color.rgb(46,125,50));
        Button gestion = makeButton("⚙  GESTIÓN", Color.rgb(239,108,0));

        pedidos.setOnClickListener(v -> open(PEDIDOS));
        gestion.setOnClickListener(v -> open(GESTION));

        root.addView(pedidos, buttonParams());
        LinearLayout.LayoutParams gp = buttonParams();
        gp.setMargins(0, 24, 0, 0);
        root.addView(gestion, gp);

        setContentView(root);
    }

    private LinearLayout.LayoutParams buttonParams() {
        return new LinearLayout.LayoutParams(-1, 76);
    }

    private Button makeButton(String text, int color) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextSize(20);
        b.setTextColor(Color.WHITE);
        b.setTypeface(Typeface.DEFAULT_BOLD);
        b.setGravity(Gravity.CENTER);
        b.setAllCaps(false);
        b.setBackgroundColor(color);
        return b;
    }

    private void open(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
