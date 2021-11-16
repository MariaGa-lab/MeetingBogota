package com.mintic.meetingbogota

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoldMuseum: Button = findViewById(R.id.gold_museum_button)
        buttonGoldMuseum.setOnClickListener {
            val intentGoldMuseum = Intent(this, MuseumGoldActivity::class.java)
            startActivity(intentGoldMuseum)
        }

        val buttonAdventureWorld: Button = findViewById(R.id.adventure_world_button)
        buttonAdventureWorld.setOnClickListener {
            val intentAdventureWorld = Intent(this, MundoAventuraActivity::class.java)
            startActivity(intentAdventureWorld)
        }

        val buttonBotanicGarden: Button = findViewById(R.id.botanic_garden_button)
        buttonBotanicGarden.setOnClickListener {
            val intentBotanicGarden = Intent(this, BotanicGardenActivity::class.java)
            startActivity(intentBotanicGarden)
        }
    }
}
