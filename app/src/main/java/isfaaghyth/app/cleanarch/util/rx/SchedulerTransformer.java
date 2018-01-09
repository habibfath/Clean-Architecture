package isfaaghyth.app.cleanarch.util.rx;

import org.reactivestreams.Publisher;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public abstract class SchedulerTransformer<T> implements ObservableTransformer<T, T>,
                                                            SingleTransformer<T, T>,
                                                            MaybeTransformer<T,T>,
                                                            CompletableTransformer,
                                                            FlowableTransformer<T, T> {

    private Scheduler subscribeOnScheduler;
    private Scheduler observeOnScheduler;

    public SchedulerTransformer(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        this.subscribeOnScheduler = subscribeOnScheduler;
        this.observeOnScheduler = observeOnScheduler;
    }

    @Override
    public CompletableSource apply(Completable upstream) {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler);
    }

    @Override
    public Publisher<T> apply(Flowable<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler);
    }

    @Override
    public MaybeSource<T> apply(Maybe<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler);
    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler);
    }

    @Override
    public SingleSource<T> apply(Single<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler);
    }

}