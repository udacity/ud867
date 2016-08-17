package com.example.android.clickcounter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.TextView;

public class ButtonClickTest extends ActivityInstrumentationTestCase2<ClickActivity> {

    private ClickActivity mClickActvity;
    private Button mButton;
    private TextView mTextView;

    public ButtonClickTest() {
        super(ClickActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        mClickActvity = getActivity();
        mButton = (Button) mClickActvity.findViewById(R.id.click_button);
        mTextView = (TextView) mClickActvity.findViewById(R.id.click_count_text_view);
    }

    @MediumTest
    public void testInitialValue() {
        int initialNumber = Integer.parseInt(mTextView.getText().toString());
        assertEquals(0, initialNumber);
    }

    @MediumTest
    public void testClick() {
        int priorNumber = Integer.parseInt(mTextView.getText().toString());
        TouchUtils.clickView(this, mButton);
        int newNumber = Integer.parseInt(mTextView.getText().toString());
        assertEquals(priorNumber + 1, newNumber);
    }
}
