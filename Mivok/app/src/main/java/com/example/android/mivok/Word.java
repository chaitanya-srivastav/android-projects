package com.example.android.mivok;
public class Word {
    private String mMivokTranslation;
    private String mDefaultTranslation;
    private int mImageResouceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String mivokTranslation, int audioResourceId){
        mMivokTranslation = mivokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String mivokTranslation, int imageResourceId, int audioResourceId){
        mMivokTranslation = mivokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResouceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getMivokTranslation(){
        return mMivokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return mImageResouceId;
    }

    public boolean hasImage(){
        return mImageResouceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
