package com.example.howdyweather.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.os.Build
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.example.howdyweather.R

class RainyScreen : AppCompatActivity() {

    private lateinit var arFragment: ArFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rainy_screen)

        arFragment = supportFragmentManager.findFragmentById(R.id.rainy_fragment) as ArFragment

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ModelRenderable.builder()
                .setSource(this, Uri.parse("file:///android_asset/rainy2.gltf"))
                .build()
                .thenAccept { renderable ->
                    arFragment.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane, motionEvent ->
                        val anchor: Anchor = hitResult.createAnchor()
                        val anchorNode = AnchorNode(anchor)
                        anchorNode.setParent(arFragment.arSceneView.scene)

                        val transformableNode = TransformableNode(arFragment.transformationSystem)
                        transformableNode.setParent(anchorNode)
                        transformableNode.renderable = renderable
                        transformableNode.select()
                    }
                }
        }
    }
}