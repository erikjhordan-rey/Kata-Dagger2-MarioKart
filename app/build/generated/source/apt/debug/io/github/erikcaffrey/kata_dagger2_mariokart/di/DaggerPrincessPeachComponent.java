// Generated by Dagger (https://google.github.io/dagger).
package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.PrincessPeachApi;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.ui.PrincessPeachActivity;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.ui.PrincessPeachActivity_MembersInjector;
import javax.inject.Provider;

public final class DaggerPrincessPeachComponent implements PrincessPeachComponent {
  private Provider<PrincessPeachApi> providesPeachApiProvider;

  private DaggerPrincessPeachComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static PrincessPeachComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.providesPeachApiProvider =
        DoubleCheck.provider(
            PrincessPeachApiModule_ProvidesPeachApiFactory.create(builder.princessPeachApiModule));
  }

  @Override
  public void inject(PrincessPeachActivity princessPeachActivity) {
    injectPrincessPeachActivity(princessPeachActivity);
  }

  private PrincessPeachActivity injectPrincessPeachActivity(PrincessPeachActivity instance) {
    PrincessPeachActivity_MembersInjector.injectPrincessPeachApi(
        instance, providesPeachApiProvider.get());
    return instance;
  }

  public static final class Builder {
    private PrincessPeachApiModule princessPeachApiModule;

    private Builder() {}

    public PrincessPeachComponent build() {
      if (princessPeachApiModule == null) {
        this.princessPeachApiModule = new PrincessPeachApiModule();
      }
      return new DaggerPrincessPeachComponent(this);
    }

    public Builder princessPeachApiModule(PrincessPeachApiModule princessPeachApiModule) {
      this.princessPeachApiModule = Preconditions.checkNotNull(princessPeachApiModule);
      return this;
    }
  }
}