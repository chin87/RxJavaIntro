import io.reactivex.Observable;

public class RxFibonacci{

    public Observable<Integer> fibonacci(){
        return Observable.create( subscriber -> {
            int prev = 0;
            int current = 1;

            subscriber.onNext( prev );
            subscriber.onNext( current );

            while(!subscriber.isDisposed()){
                int oldPrev = prev;
                prev = current;
                current = current+oldPrev;
                subscriber.onNext( current );
            }
        });
    }
}