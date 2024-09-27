package de.tubs.cs.ias.applovin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;

import de.tubs.cs.ias.applovin.databinding.CoreFunctionalityBinding;

public class D_CoreFunctionality extends Fragment implements MaxAdViewAdListener {

    private MainActivity getMainActivity() {
        return (MainActivity) this.getActivity();
    }

    private CoreFunctionalityBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CoreFunctionalityBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.displayAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaxAdView adView = binding.bannerad;
                adView.loadAd();
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

    @Override
    public void onAdExpanded(MaxAd maxAd) {
        // do nothing as it is after the ad request has been done
    }

    @Override
    public void onAdCollapsed(MaxAd maxAd) {
        // do nothing as it is after the ad request has been done
    }

    @Override
    public void onAdLoaded(MaxAd maxAd) {
        // do nothing as it is after the ad request has been done
    }

    @Override
    public void onAdDisplayed(MaxAd maxAd) {
        // do nothing as it is after the ad request has been done
    }

    @Override
    public void onAdHidden(MaxAd maxAd) {
        // do nothing as it is after the ad request has been done
    }

    @Override
    public void onAdClicked(MaxAd maxAd) {
        // do nothing as it is after the ad request has been done
    }

    @Override
    public void onAdLoadFailed(String s, MaxError maxError) {
        // do nothing as it is after the ad request has been done
    }

    @Override
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        // do nothing as it is after the ad request has been done
    }
}
