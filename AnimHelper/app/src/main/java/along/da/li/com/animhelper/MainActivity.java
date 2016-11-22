package along.da.li.com.animhelper;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String TAG = "anim";
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runRotationAnim(view);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.text2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightAnim(view);
            }
        });
    }

    private void runRotationAnim(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationY", 0f, 359f);
        animator.setDuration(1500);
        animator.start();
        Log.d(TAG, "run anim........");
    }

    private void rightAnim(View view) {
        Log.d(TAG, "run anim.......2.");
        ObjectAnimator animator = ObjectAnimator.ofInt(view, "right", view.getRight(), view.getRight() + 300);
        animator.setDuration(1500);
        //animator.setInterpolator(CubicInterpolator.OUT);
        ObjectAnimator animator2 = ObjectAnimator.ofInt(view, "left", view.getLeft(), view.getLeft() + 300);
        animator2.setDuration(1500);
        animator.start();
        animator2.start();
    }
}
