package sg.edu.np.mad.madpractical5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<User> data;
    Context context;

    public UserAdapter(ArrayList<User> input, Context context){
        this.context = context;
        this.data = input;
    }


    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        User user = data.get(position);

        if (String.valueOf(user.name).endsWith("7")) {
            holder.bigImage.setVisibility(View.VISIBLE);
        }

        holder.name.setText(user.name);
        holder.description.setText(user.description);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("Profile")
                        .setMessage(user.name)
                        .setCancelable(true)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Random rand = new Random();
                                int randomNum = rand.nextInt(999999);
                                Intent goToMainActivity  = new Intent(context, MainActivity.class);
                                goToMainActivity .putExtra("name", user.name + randomNum);
                                goToMainActivity .putExtra("description", user.description);
                                goToMainActivity .putExtra("followed", user.followed);
                                goToMainActivity .putExtra("id", user.id);
                                v.getContext().startActivity(goToMainActivity);
                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }


        });
    }

    public int getItemCount() {
        return data.size();
    }

}
