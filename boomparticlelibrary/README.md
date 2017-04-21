# BoomParticle
# 粒子爆炸(粉碎)效果

explosive dust effect for views

![explosionfield.gif](https://github.com/836948082/BoomParticle/blob/master/image/explosionfield.gif)

## Getting started

In your `build.gradle`:

```gradle
 dependencies {
   compile 'tyrantgit:explosionfield:1.0.1'
 }
```

```java
mExplosionField = ExplosionField.attach2Window(this);
addListener(findViewById(R.id.root));
```