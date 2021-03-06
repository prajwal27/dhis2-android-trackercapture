package org.dhis2.data.forms.dataentry.fields.age;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.dhis2.R;
import org.dhis2.data.forms.dataentry.fields.Row;
import org.dhis2.data.forms.dataentry.fields.RowAction;
import org.dhis2.databinding.FormAgeCustomBinding;

import io.reactivex.processors.FlowableProcessor;

/**
 * QUADRAM. Created by frodriguez on 20/03/2018.
 */

public class AgeRow implements Row<AgeHolder, AgeViewModel> {

    private final LayoutInflater inflater;
    private final boolean isBgTransparent;
    private final FlowableProcessor<RowAction> processor;
    private final String renderType;
    private boolean isSearchMode = false;

    public AgeRow(LayoutInflater layoutInflater, FlowableProcessor<RowAction> processor, boolean isBgTransparent) {
        this.inflater = layoutInflater;
        this.isBgTransparent = isBgTransparent;
        this.processor = processor;
        this.renderType = null;
        this.isSearchMode = true;
    }

    public AgeRow(LayoutInflater layoutInflater, FlowableProcessor<RowAction> processor,
                  @NonNull FlowableProcessor<Integer> currentPosition,boolean isBgTransparent, String renderType) {
        this.inflater = layoutInflater;
        this.isBgTransparent = isBgTransparent;
        this.processor = processor;
        this.renderType = renderType;
    }

    @NonNull
    @Override
    public AgeHolder onCreate(@NonNull ViewGroup parent) {
        FormAgeCustomBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.form_age_custom, parent, false);
        binding.customAgeview.setIsBgTransparent(isBgTransparent);
        return new AgeHolder(binding, processor);
    }

    @Override
    public void onBind(@NonNull AgeHolder viewHolder, @NonNull AgeViewModel viewModel) {
        viewHolder.update(viewModel);
    }

    @Override
    public void deAttach(@NonNull AgeHolder viewHolder) {
        viewHolder.dispose();
    }
}
