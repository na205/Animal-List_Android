package me.vable.android.animallist.fragment;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

import me.vable.android.animallist.R;
import me.vable.android.animallist.data.Animal;
import me.vable.android.animallist.data.adapter.AnimalListAdapter;

public class AnimalListFragment extends Fragment {

    OnFragmentInteractionListener listener;

    public AnimalListFragment(){
        return;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal_list,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView animalListView = (ListView) view.findViewById(android.R.id.list);
        AnimalListAdapter animalListAdapter = new AnimalListAdapter(getActivity(),generateAnimalList());
        animalListView.setAdapter(animalListAdapter);

        animalListView.setOnItemClickListener(onAnimalListViewItemClickListener);

    }

    AdapterView.OnItemClickListener onAnimalListViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Animal animal = (Animal)adapterView.getItemAtPosition(i);
            if(listener!=null)
                listener.onAnimalSelected(animal);
        }
    };

    private List<Animal> generateAnimalList(){
        List<Animal> animals = new ArrayList<Animal>(10);
        Animal ant = new Animal();

        ant.setName("Ant");
        ant.setImageUrl("http://upload.wikimedia.org/wikipedia/commons/8/85/WeaverAntDefense.JPG");
        ant.setDescription("Ants are eusocial insects of the family Formicidae and, along with the related wasps and bees, belong to the order Hymenoptera. Ants evolved from wasp-like ancestors in the mid-Cretaceous period between 110 and 130 million years ago and diversified after the rise of flowering plants. More than 12,500 of an estimated total of 22,000 species have been classified. They are easily identified by their elbowed antennae and the distinctive node-like structure that forms their slender waists.");
        animals.add(ant);

        Animal bird = new Animal();
        bird.setName("Bird");
        bird.setImageUrl("http://upload.wikimedia.org/wikipedia/commons/3/32/House_sparrow04.jpg");
        bird.setDescription("Birds (class Aves or clade Avialae) are feathered, winged, two-legged, warm-blooded, egg-laying vertebrates. Aves ranks as the tetrapod class with the most living species, approximately ten thousand. Extant birds belong to the subclass Neornithes, living worldwide and ranging in size from the 5 cm (2 in) bee hummingbird to the 2.75 m (9 ft) ostrich. The fossil record indicates that birds emerged within the theropod dinosaurs during the Jurassic period, around 150 million years ago. On 31 July 2014, scientists reported details of the evolution of birds from theropod dinosaurs. Most researchers agree that modern-day birds are the only living members of the Dinosauria clade.");
        animals.add(bird);

        Animal cat = new Animal();
        cat.setName("Cat");
        cat.setImageUrl("http://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Kittyply_edit1.jpg/800px-Kittyply_edit1.jpg");
        cat.setDescription("The domestic cat is a small, usually furry, domesticated, and carnivorous mammal. It is often called the housecat when kept as an indoor pet, or simply the cat when there is no need to distinguish it from other felids and felines. Cats are often valued by humans for companionship, and their ability to hunt vermin and household pests.");
        animals.add(cat);

        Animal dog = new Animal();
        dog.setName("Dog");
        dog.setImageUrl("http://upload.wikimedia.org/wikipedia/commons/1/13/Gaia_Basenji.jpg");
        dog.setDescription("The domestic dog is a member of the Canidae family of the mammalian order Carnivora. The term \"domestic dog\" is generally used for both domesticated and feral varieties. The dog was the first domesticated animal and has been the most widely kept working, hunting, and pet animal in human history. The word \"dog\" can also refer to the male of a canine species, as opposed to the word \"bitch\" which refers to the female of the species.");
        animals.add(dog);

        return animals;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof  OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onAnimalSelected(Animal animal);
    }
}