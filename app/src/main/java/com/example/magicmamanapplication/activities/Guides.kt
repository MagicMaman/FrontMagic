package com.example.magicmamanapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.data.Image
import com.example.magicmamanapplication.adapters.ImageAdapter
import com.example.magicmamanapplication.R

class Guides : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guides)

        val imageList = listOf<Image>(
            Image(
                R.drawable.img1,
                "Feeding problems: Tonsillitis",
                "The problem\n" +
                        "Tonsillitis is an inflammation of the tonsils, the almond-shaped lymph nodes that hang down at both sides of the back of the throat. Infected tonsils are a common childhood problem. The tonsils filter out germs in the throat, but sometimes a virus or bacteria causes the tonsils to swell.\n" +
                        "\n" +
                        "This can make swallowing painful. In fact, one of the signs of tonsillitis is a child who refuses to eat (although not eating can also be a sign of a bad sore throat or other illness).\n" +
                        "\n" +
                        "What you can do\n" +
                        "Your child's doctor will have to determine whether this is a case of tonsillitis, and if so, what the treatment will be. For more details, see our complete article on tonsillitis and tonsillectomy.\n" +
                        "\n" +
                        "Since eating can be painful during recovery, offer your child liquids, fruit smoothies, yogurt, and pureed soups. You can try cold drinks or ice pops, which will numb the pain a bit, or warm (not hot), soothing liquids such as broth or tea. A little honey and lemon in warm water makes a comforting tonic.\n" +
                        "\n" +
                        "Note: Don't give honey to a child younger than age 1."
            ),
            Image(
                R.drawable.img2,
                "When can my baby start taking music classes?",
                " \"Around 18 months is when kids really enjoy rhythmic movement, and making 'music' by banging on drums, and jingling bells,\" says Victoria J. Youcha, of Zero to Three, a nonprofit organization devoted to the healthy development of infants and toddlers. Your toddler may have fun at a music appreciation class at this age — most of these classes also incorporate a bit of free-form dance, which gives your toddler a chance to practice his developing motor skills.\n" +
                        "\n" +
                        "Some music classes are designed for babies to attend with their parents, but these very early parent and child or \"mommy and me\" music classes will probably benefit you more than your baby. Babies do enjoy listening to new sounds but they don't yet have the attention span or comprehension to fully grasp music. A class like this in the early baby months, however, can give you a chance to get out of the house and make friends with other new parents.\n" +
                        "\n" +
                        "Some say when your child is able to focus on a task such as putting together a puzzle or listening to a story for 15 minutes, he'll probably be able to concentrate enough to start music lessons. It's probably best, however, to hold off on formal instrument training until your child's at least 3, when his brain circuits for music training begin to mature.\n" +
                        "\n" +
                        "Some programs, such as Suzuki, teach instruments ranging from the flute to the violin to 3-year-olds. But remember, this kind of program requires your involvement too. In order to participate in some programs geared toward preschool-aged kids, you must be willing to sit in on your child's lessons — and direct his practicing at home.\n" +
                        "\n" +
                        "\"If your child seems to enjoy the instrument, and you're willing to put in the time, there's no reason not to try it,\" says Youcha."
            ),
            Image(
                R.drawable.img3,
                "When can my baby go in a pool?",
                "Even pools that look pristine can harbor dangers for infants. Pools can easily be contaminated with bacteria that cause diarrhea, which can be very dangerous for a young infant.\n" +
                        "\n" +
                        "\"For newborns younger than 2 months we really worry about immunity – how vulnerable babies are to illness – so I recommend that parents not take their young infants into swimming pools, lakes, the ocean, and so on,\" says Howard Reinstein, a pediatrician in Encino, California and a spokesperson for the American Academy of Pediatrics (AAP).\n" +
                        "\n" +
                        "Also keep in mind that babies have more skin relative to their weight when compared with older children, which means babies' body temperature can change very quickly. Because your baby won't be big enough to regulate his body temperature very well until he's about 12 months old, make sure the water's warm enough for him.\n" +
                        "\n" +
                        "\"If the water feels chilly to you, it will be really cold for your baby,\" Dr. Reinstein says. For your baby to be comfortable, the temperature of pool water should be between 85 and 87 degrees Fahrenheit. If he starts shivering, it's time to get out.\n" +
                        "\n" +
                        "It can also be dangerous if the water is too hot. Hot tubs, spas, and pools heated to more than 100 degrees Fahrenheit are off limits to children younger than 3. Young children overheat more quickly than adults, and the high temperatures in hot tubs can cause a child's heart to race or pose other dangers.\n" +
                        "\n" +
                        "And of course there's the issue of water safety: Drowning and near drowning are leading causes of death and injury for young children. Keep the following safety tips in mind when you're around any body of water with your child:\n" +
                        "\n" +
                        "The AAP recommends \"touch supervision,\" meaning that an adult stays within arm's reach of an infant or toddler at all times whenever a child is in or near a body of water.\n" +
                        "Always hold your baby in the pool, and don't wade into water too deep for you to maintain firm footing.\n" +
                        "As soon as your child learns to walk, start teaching him not to run when he's near a pool. Also emphasize that he must never enter the water without an adult nearby to supervise.\n" +
                        "Never rely on inflatable toys (like water wings) to keep your child safe from drowning. Have your child wear a personal flotation device (PFD) that fits properly and is approved by the U.S. Coast Guard. He should wear the PFD at all times in and around water.\n" +
                        "Check out the Coast Guard's website for a list of manufacturers that make PFDs for young children and tips on how to use flotation devices safely."
            ),
            Image(
                R.drawable.img4,
                "Image 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            ),
            Image(
                R.drawable.img5,
                "Image 5",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}