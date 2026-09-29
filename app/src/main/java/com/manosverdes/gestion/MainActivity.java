package com.manosverdes.gestion;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
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
        root.setPadding(dp(28), dp(36), dp(28), dp(28));
        root.setBackgroundColor(Color.rgb(247, 244, 231));

        TextView title = new TextView(this);
        title.setText("MANOS VERDES");
        title.setTextColor(Color.rgb(11, 61, 32));
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView subtitle = new TextView(this);
        subtitle.setText("GESTIÓN");
        subtitle.setTextColor(Color.rgb(46, 125, 50));
        subtitle.setTextSize(22);
        subtitle.setTypeface(Typeface.DEFAULT_BOLD);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(-1, -2);
        sp.setMargins(0, dp(4), 0, dp(30));
        root.addView(subtitle, sp);

        Button pedidos = makeButton("🛒  PEDIDOS", Color.rgb(46, 125, 50), 20);
        Button gestion = makeButton("⚙  GESTIÓN", Color.rgb(239, 108, 0), 20);
        Button copiar = makeButton("COPIAR ENLACE A PÁGINA DE PEDIDOS", Color.rgb(11, 61, 32), 16);

        pedidos.setOnClickListener(v -> open(PEDIDOS));
        gestion.setOnClickListener(v -> open(GESTION));
        copiar.setOnClickListener(v -> copyPedidosLink());

        root.addView(pedidos, buttonParams());
        LinearLayout.LayoutParams gp = buttonParams();
        gp.setMargins(0, dp(16), 0, 0);
        root.addView(gestion, gp);

        LinearLayout.LayoutParams cp = buttonParams();
        cp.setMargins(0, dp(16), 0, 0);
        root.addView(copiar, cp);

        setContentView(root);
    }

    private LinearLayout.LayoutParams buttonParams() {
        return new LinearLayout.LayoutParams(-1, dp(58));
    }

    private Button makeButton(String text, int color, float textSize) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextSize(textSize);
        b.setTextColor(Color.WHITE);
        b.setTypeface(Typeface.DEFAULT_BOLD);
        b.setGravity(Gravity.CENTER);
        b.setAllCaps(false);
        b.setIncludeFontPadding(true);
        b.setMinHeight(0);
        b.setMinimumHeight(0);
        b.setPadding(dp(8), 0, dp(8), 0);
        b.setBackgroundColor(color);
        return b;
    }

    private void open(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    private void copyPedidosLink() {
        ClipboardManager clipboard =
                (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText("Página de pedidos", PEDIDOS));
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }
}
