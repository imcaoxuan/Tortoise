package top.caoxuan.tortoise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    private WebView webView;
    private static final String TAG = SecondFragment.class.getSimpleName();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.d(TAG, "onCreateView: ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");

        /*view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });*/
        webView = view.findViewById(R.id.second_web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setTextZoom(100);

    }

    static class MyWebViewClient extends WebViewClient {

        String username;
        String password;

        public MyWebViewClient(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
           /* String username = "user@caoxuan.top";
            String password = "bc03cfa0-26b1-4a58-bb80-b33dbbef4436";*/
            view.loadUrl("javascript: {alert();" +
                    "document.getElementById('inputEmail').value = '" + username + "';" +
                    "document.getElementById('inputPassword').value = '" + password + "';" +
                    "var loginForm = document.getElementById('form');" +
                    "loginForm.submit(); }");
        }
    }
}