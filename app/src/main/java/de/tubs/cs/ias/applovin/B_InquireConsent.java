package de.tubs.cs.ias.applovin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.applovin.sdk.AppLovinPrivacySettings;

import de.tubs.cs.ias.applovin.databinding.InquireConsentBinding;

public class B_InquireConsent extends Fragment {

    private InquireConsentBinding binding;
    private CharSequence text = "2.State: Consent";


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = InquireConsentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonConsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = B_InquireConsent.this.getActivity().getApplicationContext();
                AppLovinPrivacySettings.setHasUserConsent( true, context );
                binding.textviewInquireConsent.setText(text + " [GIVEN]");
            }
        });
        binding.buttonNoconsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = B_InquireConsent.this.getActivity().getApplicationContext();
                AppLovinPrivacySettings.setHasUserConsent( false, context );
                binding.textviewInquireConsent.setText(text + " [REFUSED]");
            }
        });

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(B_InquireConsent.this)
                        .navigate(R.id.action_InquireConsent_to_Initialize);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
