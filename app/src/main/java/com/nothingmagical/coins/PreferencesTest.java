package com.nothingmagical.coins;


import android.content.Context;
import android.content.SharedPreferences;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

public class PreferencesTest {

    private SharedPreferences sharedPrefs;
    private Context context;


    @Before
    public void before() throws Exception {
        this.sharedPrefs = Mockito.mock(SharedPreferences.class);
        this.context = Mockito.mock(Context.class);
        Mockito.when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs);
    }

    @Test
    public void getBtcString() throws Exception {
        Mockito.when(sharedPrefs.getString(anyString(), anyString())).thenReturn("foobar");
        assertEquals("foobar", Preferences.getBtcString(context));
    }

    @Test
    public void getBtc() throws Exception {
        Mockito.when(sharedPrefs.getString(anyString(), anyString())).thenReturn("1.3");
        assertEquals(1.3, Preferences.getBtc(context), 0.001);
    }

    @Test
    public void getCurrencyCode() throws Exception {
        Mockito.when(sharedPrefs.getString(Preferences.KEY_CURRENCY, "USD")).thenReturn("USD");
        assertEquals("USD", Preferences.getCurrencyCode(context));
    }

    @Test
    public void getRate() throws Exception {
        Mockito.when(sharedPrefs.getString(Preferences.KEY_CURRENCY, "USD")).thenReturn("USD");
        Mockito.when(sharedPrefs.getString("USD", "0")).thenReturn("300");
        assertEquals(300, Preferences.getRate(context), 0.001);
    }

    @Test
    public void getUpdatedAtTimestamp() throws Exception {
        Mockito.when(sharedPrefs.getLong(Preferences.KEY_UPDATED_AT, 0)).thenReturn(Long.valueOf(123456));
        assertEquals(123456, Preferences.getUpdatedAtTimestamp(context));
    }

}