package de.tubs.cs.ias.applovin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

import de.tubs.cs.ias.applovin.databinding.InitializeBinding;

public class C_Initialize extends Fragment {

    private InitializeBinding binding;
    private CharSequence text = "3. Step: Initialize";


    private MainActivity getMainActivity() {
        return (MainActivity) this.getActivity();
    }

    private void initializeAppLovinSDK() {
        Context context = getMainActivity().getApplicationContext();
        MainActivity.applovin.setMediationProvider("max");
        AppLovinSdk.initializeSdk(context, new AppLovinSdk.SdkInitializationListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {
                // AppLovin SDK is initialized, start loading ads
                binding.textviewInitialize.setText("initialized!");
            }
        });
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = InitializeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonInitialize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeAppLovinSDK();
                binding.textviewInitialize.setText(text + " [DONE]");
            }
        });

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(C_Initialize.this)
                        .navigate(R.id.action_Initialize_to_CoreFunctionality);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}