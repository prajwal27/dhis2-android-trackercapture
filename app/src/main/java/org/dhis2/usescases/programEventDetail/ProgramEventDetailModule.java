package org.dhis2.usescases.programEventDetail;

import com.squareup.sqlbrite2.BriteDatabase;

import org.dhis2.data.dagger.PerActivity;
import org.dhis2.data.metadata.MetadataRepository;
import org.hisp.dhis.android.core.D2;

import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Cristian on 13/02/2018.
 */
@PerActivity
@Module
public class ProgramEventDetailModule {


    @Provides
    @PerActivity
    ProgramEventDetailContract.View provideView(ProgramEventDetailActivity activity) {
        return activity;
    }

    @Provides
    @PerActivity
    ProgramEventDetailContract.Presenter providesPresenter(@NonNull ProgramEventDetailRepository programEventDetailRepository,
                                                           @NonNull MetadataRepository metadataRepository) {
        return new ProgramEventDetailPresenter(programEventDetailRepository, metadataRepository);
    }

    @Provides
    @PerActivity
    ProgramEventDetailAdapter provideProgramEventDetailAdapter(ProgramEventDetailContract.Presenter presenter) {
        return new ProgramEventDetailAdapter(presenter);
    }

    @Provides
    @PerActivity
    ProgramEventDetailRepository eventDetailRepository(BriteDatabase briteDatabase,D2 d2) {
        return new ProgramEventDetailRepositoryImpl(briteDatabase,d2);
    }
}
