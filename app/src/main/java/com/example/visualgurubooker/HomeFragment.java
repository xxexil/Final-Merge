    package com.example.visualgurubooker;

    import android.content.Intent;
    import android.os.Bundle;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.cardview.widget.CardView;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentTransaction;


    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    
    
    public class HomeFragment extends Fragment implements View.OnClickListener{


        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;
        public CardView googlemap, twitter, spotify, facebook;
        private Button buttonn;
        public HomeFragment() {
            // Required empty public constructor
        }

        public static HomeFragment newInstance(String param1, String param2) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;




        }

        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            googlemap.setOnClickListener(this);
            twitter.setOnClickListener(this);
            spotify.setOnClickListener(this);
            facebook.setOnClickListener(this);




            Button button = view.findViewById(R.id.button8);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click
                    openMainActivity2();
                }

            });
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }

        }

        public void openMainActivity2() {
            Intent intent = new Intent(getActivity(), Activity2.class);
            startActivity(intent);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_home, container, false);
            googlemap = view.findViewById(R.id.googlemap);
            twitter = view.findViewById(R.id.twitter);
            spotify = view.findViewById(R.id.spotify);
            facebook = view.findViewById(R.id.facebook);
            return view;
        }


        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.googlemap) {
                Intent i = new Intent(getActivity(), googlemap.class);
                startActivity(i);
            } else if (view.getId() == R.id.spotify) {
                Intent i = new Intent(getActivity(), spotify.class);
                startActivity(i);
            } else if (view.getId() == R.id.twitter) {
                Intent i = new Intent(getActivity(), twitter.class);
                startActivity(i);
            } else if (view.getId() == R.id.facebook) {
                Intent i = new Intent(getActivity(), facebook.class);
                startActivity(i);
            }
        }

        private void repFragment(Fragment fragment) {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_out,fragment);
            fragmentTransaction.commit();

        }


    }
